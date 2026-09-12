```mermaid
classDiagram
    class Cliente {
        +String idCliente
        +String nombre
        +String telefono
        +String email
        +String direccion
        +registrarEnvio()
    }

    class Envio {
        +String numeroGuia
        +Double pesoKg
        +Double costo
        +Date fechaCreacion
        +Ubicacion origen
        +Ubicacion destino
        +EstadoEnvio estadoActual
        +asignarRepartidor(Repartidor r)
        +actualizarEstado(EstadoEnvio nuevoEstado)
    }

    class Ubicacion {
        +String direccion
        +String ciudad
        +String departamento
        +String codigoPostal
    }

    class HistorialEstado {
        +String idHistorial
        +EstadoEnvio estado
        +DateTime fechaHora
        +String comentario
    }

    class Repartidor {
        +String idRepartidor
        +String nombre
        +String telefono
        +Boolean disponible
        +asignarVehiculo(Vehiculo v)
    }

    class Vehiculo {
        +String placa
        +String tipo
        +Double capacidadCargaKg
        +String estadoVehiculo
    }

    class Entrega {
        +String idEntrega
        +DateTime fechaHoraEntrega
        +String nombreReceptor
        +String firmaDigital
        +Boolean exitosa
        +completarEntrega()
    }

    class EstadoEnvio {
        <<enumeration>>
        REGISTRADO
        EN_TRANSITO
        EN_RUTA_ENTREGA
        ENTREGADO
        NO_ENTREGADO
    }

    Cliente "1" -- "0..*" Envio : realiza / recibe >
    Envio "1" *-- "2" Ubicacion : contiene (origen y destino) >
    Envio "1" *-- "1..*" HistorialEstado : rastrea >
    HistorialEstado "1" -- "1" EstadoEnvio : clasificado por >
    Envio "0..*" -- "0..1" Repartidor : asignado a >
    Repartidor "0..1" -- "0..1" Vehiculo : conduce >
    Envio "1" -- "0..1" Entrega : finaliza en >
    Repartidor "1" -- "0..*" Entrega : ejecuta >