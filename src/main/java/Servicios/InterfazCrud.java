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
     * M�todo para eliminar elemento
     * @return eliminar elemento
     * @author Sergio Garcia
     * @since 14/12/2023
     */
    public void eliminarElemento();
    /**
     * M�todo para modificar cantidad del elemento
     * @return modificar cantidad elemento
     * @author Sergio Garcia
     * @since 14/12/2023
     */
    public void modificarCantidadElemento();
    /**
     * M�todo para mostrar el stock.
     * @return mostrar stock
     * @author Sergio Garcia
     * @since 14/12/2023
     */
    public void mostrarStock();
    /**
     * M�todo crear reserva
     * @return crear reserva
     * @author Sergio Garcia
     * @since 14/12/2023
     */
    public void crearReserva();

}
