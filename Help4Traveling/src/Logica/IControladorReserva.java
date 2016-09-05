/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author Leonardo
 */
public interface IControladorReserva {

    //Nueva reserva
    public abstract Reserva nuevaRserva(String nickname, double precio);

    public abstract void agregarItem(Reserva nueva, int cantidad, Date fi, Date ff, Oferta oferta);

    public abstract DtReserva verReserva(Reserva nueva);

    public abstract void altaReserva(Reserva nueva);

    public abstract List<DtReserva> listarReservas();

    public abstract List<ItemReserva> listarItems(Integer reserva);

    public abstract void altaDeReserva();

    public abstract void actualizarEstadoDeReserva(Integer reserva, String estado);

    public abstract void verInfoDeReserva();

    public abstract void cancelarUnaReserva(long id);

    public abstract void setReservasDB();

    public abstract void setItemsDB();

}
