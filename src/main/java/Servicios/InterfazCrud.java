package Servicios;

public interface InterfazCrud {
	 /**
     * Metodo para crear elemento
     * @author Sergio Garcia
     * @since 14/12/2023
     * @return crear elemento
     */
    public void crearElemento();
    /**
     * Método para eliminar elemento
     * @return eliminar elemento
     * @author Sergio Garcia
     * @since 14/12/2023
     */
    public void eliminarElemento();
    /**
     * Método para modificar cantidad del elemento
     * @return modificar cantidad elemento
     * @author Sergio Garcia
     * @since 14/12/2023
     */
    public void modificarCantidadElemento();
    /**
     * Método para mostrar el stock.
     * @return mostrar stock
     * @author Sergio Garcia
     * @since 14/12/2023
     */
    public void mostrarStock();
    /**
     * Método crear reserva
     * @return crear reserva
     * @author Sergio Garcia
     * @since 14/12/2023
     */
    public void crearReserva();

}
