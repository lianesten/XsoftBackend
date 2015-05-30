package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

public class ServicioVentaId  implements java.io.Serializable {


    private int idservicioVenta;
    private int idservicio;
    private int idventa;

   public ServicioVentaId() {
   }

   public ServicioVentaId(int idservicioVenta, int idservicio, int idventa) {
      this.idservicioVenta = idservicioVenta;
      this.idservicio = idservicio;
      this.idventa = idventa;
   }
  
   public int getIdservicioVenta() {
       return this.idservicioVenta;
   }
   
   public void setIdservicioVenta(int idservicioVenta) {
       this.idservicioVenta = idservicioVenta;
   }
   public int getIdservicio() {
       return this.idservicio;
   }
   
   public void setIdservicio(int idservicio) {
       this.idservicio = idservicio;
   }
   public int getIdventa() {
       return this.idventa;
   }
   
   public void setIdventa(int idventa) {
       this.idventa = idventa;
   }


  public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ServicioVentaId) ) return false;
		 ServicioVentaId castOther = ( ServicioVentaId ) other; 
        
		 return (this.getIdservicioVenta()==castOther.getIdservicioVenta())
&& (this.getIdservicio()==castOther.getIdservicio())
&& (this.getIdventa()==castOther.getIdventa());
  }
  
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + this.getIdservicioVenta();
        result = 37 * result + this.getIdservicio();
        result = 37 * result + this.getIdventa();
        return result;
  }   


}
