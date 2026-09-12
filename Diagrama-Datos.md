erDiagram
    CLIENTE {
        UUID id_cliente PK
        VARCHAR nombre
        VARCHAR telefono
        VARCHAR email
        TEXT direccion
        TIMESTAMP fecha_registro
    }

    UBICACION {
        UUID id_ubicacion PK
        VARCHAR direccion
        VARCHAR ciudad
        VARCHAR departamento
        VARCHAR codigo_postal
    }

    VEHICULO {
        VARCHAR placa PK
        VARCHAR tipo
        DECIMAL capacidad_carga_kg
        VARCHAR estado_vehiculo
    }

    REPARTIDOR {
        UUID id_repartidor PK
        VARCHAR nombre
        VARCHAR telefono
        BOOLEAN disponible
        VARCHAR placa_vehiculo FK
    }

    ENVIO {
        UUID id_envio PK
        VARCHAR numero_guia UK
        DECIMAL peso_kg
        DECIMAL costo
        TIMESTAMP fecha_creacion
        VARCHAR estado_actual
        UUID id_cliente FK
        UUID id_origen FK
        UUID id_destino FK
        UUID id_repartidor FK
    }

    HISTORIAL_ESTADO {
        UUID id_historial PK
        UUID id_envio FK
        VARCHAR estado
        TIMESTAMP fecha_hora
        TEXT comentario
    }

    ENTREGA {
        UUID id_entrega PK
        UUID id_envio FK
        UUID id_repartidor FK
        TIMESTAMP fecha_hora_entrega
        VARCHAR nombre_receptor
        TEXT firma_digital
        BOOLEAN exitosa
    }

    CLIENTE ||--o{ ENVIO : "registra"
    UBICACION ||--o{ ENVIO : "es origen de"
    UBICACION ||--o{ ENVIO : "es destino de"
    VEHICULO ||--o| REPARTIDOR : "es conducido por"
    REPARTIDOR ||--o{ ENVIO : "tiene asignado"
    ENVIO ||--o{ HISTORIAL_ESTADO : "registra cambios de"
    ENVIO ||--o| ENTREGA : "concluye en"
    REPARTIDOR ||--o{ ENTREGA : "ejecuta"




