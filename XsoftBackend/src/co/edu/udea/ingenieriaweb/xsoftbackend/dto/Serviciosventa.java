package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

import java.util.Date;


public class Serviciosventa  implements java.io.Serializable {


    private ServicioVentaId id;
    private Servicios servicios;
    private Venta venta;
    private double totalventa;
    private Date fechaCaducidad;
    private int cantidad;
    private Date fechaVenta;

   public Serviciosventa() {
   }

   public Serviciosventa(ServicioVentaId id, Servicios servicios, Venta venta, double totalventa, Date fechaCaducidad, int cantidad, Date fechaVenta) {
      this.id = id;
      this.servicios = servicios;
      this.venta = venta;
      this.totalventa = totalventa;
      this.fechaCaducidad = fechaCaducidad;
      this.cantidad = cantidad;
      this.fechaVenta = fechaVenta;
   }
  
   public ServicioVentaId getId() {
       return this.id;
   }
   
   public void setId(ServicioVentaId id) {
       this.id = id;
   }
   public Servicios getServicios() {
       return this.servicios;
   }
   
   public void setServicios(Servicios servicios) {
       this.servicios = servicios;
   }
   public Venta getVenta() {
       return this.venta;
   }
   
   public void setVenta(Venta venta) {
       this.venta = venta;
   }
   public double getTotalventa() {
       return this.totalventa;
   }
   
   public void setTotalventa(double totalventa) {
       this.totalventa = totalventa;
   }
   public Date getFechaCaducidad() {
       return this.fechaCaducidad;
   }
   
   public void setFechaCaducidad(Date fechaCaducidad) {
       this.fechaCaducidad = fechaCaducidad;
   }
   public int getCantidad() {
       return this.cantidad;
   }
   
   public void setCantidad(int cantidad) {
       this.cantidad = cantidad;
   }
   public Date getFechaVenta() {
       return this.fechaVenta;
   }
   
   public void setFechaVenta(Date fechaVenta) {
       this.fechaVenta = fechaVenta;
   }




}