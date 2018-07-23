package servicios.enums;

public enum TipoNotificacion {
    MENCION("MENCION"),
    COMENTARIO("COMENTARIO"),
    SOLICITUD("SOLICITUD");

    private String tipoNotificacion;

    TipoNotificacion(String tipoNotificacion){
        this.tipoNotificacion = tipoNotificacion;
    }

    public String getTipoNotificacion(){
        return tipoNotificacion;
    }
}
