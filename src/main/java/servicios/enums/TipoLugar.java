package servicios.enums;

public enum TipoLugar {

    TRABAJO("TRABAJO"),
    ESTUDIO("ESTUDIO");

    private String tipoLugar;

    TipoLugar(String tipoLugar){
        this.tipoLugar = tipoLugar;
    }

    public String getTipoLugar(){
        return tipoLugar;
    }
}
