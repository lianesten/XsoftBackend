package co.edu.udea.ingenieriaweb.xsoftbackend.dto;
// Generated 28/05/2015 11:07:23 PM by Hibernate Tools 4.3.1



/**
 * ClienteId generated by hbm2java
 */
public class ClienteId  implements java.io.Serializable {


     private int tipoId;
     private String numeroId;

    public ClienteId() {
    }

    public ClienteId(int tipoId, String numeroId) {
       this.tipoId = tipoId;
       this.numeroId = numeroId;
    }
   
    public int getTipoId() {
        return this.tipoId;
    }
    
    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }
    public String getNumeroId() {
        return this.numeroId;
    }
    
    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ClienteId) ) return false;
		 ClienteId castOther = ( ClienteId ) other; 
         
		 return (this.getTipoId()==castOther.getTipoId())
 && ( (this.getNumeroId()==castOther.getNumeroId()) || ( this.getNumeroId()!=null && castOther.getNumeroId()!=null && this.getNumeroId().equals(castOther.getNumeroId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getTipoId();
         result = 37 * result + ( getNumeroId() == null ? 0 : this.getNumeroId().hashCode() );
         return result;
   }   


}


