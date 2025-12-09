# Bounded Contexts

## Nota

Los id auto generados se heredan del `AuditableAbstractAggregateRoot` de la carpeta `shared`.

## Orbit Threshold

- Bounded Context: `regulations`
- No auditable

### Atributos

- `id` (Long, Primary Key, Autogenerado)
- `orbitClass` (String, obligatorio, no vacío)
- `maxSafeDuration` (Integer, obligatorio, positivo).

### Nota

Requiere que su información sea poblada en la base de datos de forma automática asociada al ApplicationReady event.

| `id` | `orbitClass` | `maxSafeDuration` |
| ---- | ------------ | ----------------- |
| 1    | LEO          | 300               |
| 2    | MEO          | 450               |
| 3    | GEO          | 600               |

## Mission Assignment

- Bounded Context: `missions`
- Auditable, por ende tiene los atributos `createdAt` y `updatedAt`

### Atributos

- `id` (Long, Primary Key, Autogenerado),
- `satelliteCode` (identificador del negocio, embedded type Obligatorio, No vacío, solo puede contener un valor UUID válido)
- `orbitClass` (String, obligatorio, no vacío)
- `estimatedDuration` (Integer, obligatorio, positivo)
- `status` (MissionAssignmentStatus enumeration, obligatorio, no nulo)
- `requestedAt` (LocalDateTime, obligatorio, no nulo)

#### MissionAssignmentStatus enum

| id  | Name      |
| --- | --------- |
| 0   | SCHEDULED |
| 1   | REJECTED  |

### Nota

Especifica que al momento de registrar un **mission assignment**, si el valor de `estimatedDuration` **es menor al 20%** del `maxSafeDuration` permitido para la `orbitClass`, se considera un uso subóptimo del nodo satelital. En estos casos, la misión se registra normalmente, pero se debe emitir un evento `OrbitWindowUnderutilizedEvent`

## Alert

- Bounded Context: `monitoring`
- Auditable, por ende tiene los atributos `createdAt` y `updatedAt`

### Atributos

- `id` (Long, Primary Key, autogenerado)
- `satelliteCode` (identificador del negocio, embedded type obligatorio, no vacío, solo puede contener un valor UUID válido)
- `alertType` (AlertType enumeration, obligatorio, no nulo),
- `registeredAt` (LocalDateTime, obligatorio, no vacío, generado automáticamente al momento del registro).

#### AlertType enum

| `id` | `Name`                  |
| ---- | ----------------------- |
| 0    | UNSAFE_ORBIT_TASK       |
| 1    | NODE_COMMUNICATION_LOST |
| 2    | SYSTEM_ERROR            |
| 3    | OTHER                   |

# Business Rules

- Especifica que el atributo `satelliteCode` debe ser embedded y solo puede contener un valor UUID válido, que debe proporcionarse (no autogenerarse) al momento de registrarse el mission assignment.
- Especifica que `satelliteCode` se considera un identificador interno del negocio.
- No se debe registrar en la base de datos dos mission assignments con el mismo valor de `satelliteCode` en el mismo día.
- Requiere que el valor de `requestedAt` no sea mayor que la fecha actual.

# Domain Events

## OrbitWindowUnderutilizedEvent

Debe registrar una alert para el `satelliteCode`, con `SYSTEM_ERROR` como `alertType`.

# Casos de prueba

## No emiten eventos

### Registro válido (LEO)

```json
{
  "satelliteCode": "a1b2c3d4-e5f6-4789-a012-345678901234",
  "orbitClass": "LEO",
  "estimatedDuration": 60,
  "status": "SCHEDULED",
  "requestedAt": "2025-12-09T10:00:00"
}
```

### Registro válido (MEO)

```json
{
  "satelliteCode": "c3d4e5f6-a7b8-4901-c234-567890123456",
  "orbitClass": "MEO",
  "estimatedDuration": 100,
  "status": "SCHEDULED",
  "requestedAt": "2025-12-09T12:00:00"
}
```

### Registro válido (GEO)

```json
{
  "satelliteCode": "e5f6a7b8-c9d0-4123-e456-789012345678",
  "orbitClass": "GEO",
  "estimatedDuration": 150,
  "status": "SCHEDULED",
  "requestedAt": "2025-12-09T14:00:00"
}
```

## Emiten eventos

### Registro válido (LEO)

```json
{
  "satelliteCode": "b2c3d4e5-f6a7-4890-b123-456789012345",
  "orbitClass": "LEO",
  "estimatedDuration": 50,
  "status": "SCHEDULED",
  "requestedAt": "2025-12-09T11:00:00"
}
```

### Registro válido (MEO)

```json
{
  "satelliteCode": "d4e5f6a7-b8c9-4012-d345-678901234567",
  "orbitClass": "MEO",
  "estimatedDuration": 80,
  "status": "SCHEDULED",
  "requestedAt": "2025-12-09T13:00:00"
}
```

### Registro válido (GEO)

```json
{
  "satelliteCode": "f6a7b8c9-d0e1-4234-f567-890123456789",
  "orbitClass": "GEO",
  "estimatedDuration": 100,
  "status": "SCHEDULED",
  "requestedAt": "2025-12-09T15:00:00"
}
```

# Endpoints

## Mission Assignments Endpoint `(/api/v1/mission-assignments)`

- Implementar una operación `POST`
- El `id` es **autogenerado**
- `satelliteCode` se proporciona como String y debe convertirse a un UUID válido.
- Debe retornar un `201`
- Incluir en el response el id generado y los demás atributos, **hasta los de auditoría**

## Alerts Endpoint `(/api/v1/alerts)`

- Implementar una operación `GET`
- Retornar un `200`
- Incluir en la response todos los atributos, **hasta los de auditoría**
