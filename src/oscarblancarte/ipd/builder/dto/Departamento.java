package oscarblancarte.ipd.builder.dto;

/**
 *
 * @author ronny
 */
public class Departamento {
    private String departamento;
    
    public Departamento() {        
    }
    
    public Departamento (String departamento){
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public String toString() {
        return "Departamento{" + "departamento=" + departamento + '}';
    }
    
}
