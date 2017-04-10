
package ModelosTablas;

//Clase para presentar los datos en la tabla buscarProductos del formulario ConteoDiario
    public class tablaBuscarProducto{

        public tablaBuscarProducto() {
        }
        
        int idProducto;
        String producto;
        String presentacion;

        public int getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(int idProducto) {
            this.idProducto = idProducto;
        }

        public String getProducto() {
            return producto;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public String getPresentacion() {
            return presentacion;
        }

        public void setPresentacion(String presentacion) {
            this.presentacion = presentacion;
        }

        @Override
        public String toString() {
            return "modeloTablaPresentacion{" + "idProducto=" + idProducto + ", producto=" + producto + ", presentacion=" + presentacion + '}';
        }
        
    }
