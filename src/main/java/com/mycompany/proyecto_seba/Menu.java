package com.mycompany.proyecto_seba;

import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) {
        
        //PRODUCTOS EXISTENTES
        Producto arrayProductos[] = new Producto[100];
        arrayProductos[0] = new Producto("Monitor", 99990.0, 50);
        arrayProductos[1] = new Producto("Audifonos", 19990.0, 50);
        arrayProductos[2] = new Producto("Notebook", 449990.0, 50);
        arrayProductos[3] = new Producto("Gabinete", 54990.0, 50);
        arrayProductos[4] = new Producto("Mouse", 18990.0, 50);
        
        
        //ARRAY DONDE SE GUARDARDARÁN LAS COMPRAS REALIZADAS
        Compra arrayCompras[] = new Compra[1000];
        
        //CREACIÓN DE MENU
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("MENU DE OPCIONES\n"+
                    "\n1. Ingresar una Compra"+
                    "\n2. Ingresar un producto nuevo a bodega"+
                    "\n3. Consultar stock de un producto"+
                    "\n4. Mostrar productos sin stock"+
                    "\n5. Buscar Compra por cliente"+
                    "\n6. Mostrar total recaudado por Compras con TARJETA"+
                    "\n7. Mostrar total recaudado por Compras con EFECTIVO"+
                    "\n8. Mostrar total recaudado"+
                    "\n9. SALIR\n"+
                    "\n INGRESE UNA OPCIÓN "));
            
            switch (op) {
                case 1:
                    //INGRESE CÓDIGO CORRESPONDIENTE A LA OPCIÓN 1
                    String listaP = "";  
                    int largoP = 0;
                    int largoC = 0;
                    int opc1 = 0;
                    int opc2 = 0;
                    int cantidad = 0;
                    double totPago = 0;
                    String metPago = "";
                    String rut = "";
                    boolean conExit = false;
                    

                    
                    //busca final de producto
                    for (int i = 0; arrayProductos[i] != null ; i++) {
                        largoP++;
                        listaP += "\n" + (i + 1) + ". " + arrayProductos[i].getNombre();
                    }
                    
                    //final de compras
                    for (int i = 0; arrayCompras[i] != null; i++) {
                        largoC++;
                    }

                    //solo ingresa si no es nulo
                    do {

                        rut = JOptionPane.showInputDialog(null,"Ingrese rut");
                        
                    } while (rut.equals(""));
                    
                    //crear arreglo con todos los stocks
                    int compraReciente[] = new int[largoP];
                    
                    //llenar de stocks
                    for (int i = 0; i < largoP; i++) {
                        compraReciente[i] = arrayProductos[i].getStock();
                    }
                    
                    //crear lista
                    do {
                        opc1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione producto a comprar\n"+ listaP + "\n" + (largoP + 1) + ". Salir\n" + (largoP + 2) + ". Pagar"  ));
                        
                        if (opc1 > 0 && opc1 <= largoP) {
                            
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock Disponible: "+compraReciente[opc1-1]));
                            
                            if (cantidad <= compraReciente[opc1-1]) {
                                totPago += arrayProductos[opc1-1].getPrecio();
                               compraReciente[opc1-1] -= cantidad;
                                
                            }else{  
                            JOptionPane.showMessageDialog(null, "Cantidad no disponible");
                            }
                            
                        }else if(opc1 != largoP + 1 && opc1 != largoP + 2){
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                        }
                        
                        if (opc1 == largoP + 2) {
                            opc2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Total a pagar: "+totPago +"\n"
                                + "Seleccione metodo pago\n"
                                + "1. Tarjeta\n"
                                + "2. Efectivo\n"
                            ));
                             

                            switch (opc2) {
                                case 1:
                                    metPago = "Tarjeta";
                                    if (totPago < 300000) {
                                        totPago = totPago + (totPago * 0.05);
                                    }
                                    for (int i = 0; i < largoP; i++) {
                                        arrayProductos[i].setStock(compraReciente[i]);
                                    }
                                    conExit = true;
                                    break;
                                case 2:
                                    metPago = "Efectivo";
                                    if (totPago > 500000) {
                                        totPago = totPago - (totPago * 0.2);
                                    }else{
                                        totPago = totPago - (totPago * 0.05);
                                    }
                                    for (int i = 0; i < largoP; i++) {
                                        arrayProductos[i].setStock(compraReciente[i]);
                                    }
                                    conExit = true;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                            }
                                    
                        }
 
                        //boton salir o compra exitosa
                    }while(opc1 != largoP + 1 && conExit == false);
                    
                   
                    
                    if (metPago != "") {
                        arrayCompras[largoC] = new Compra(rut,totPago,metPago);

                    }
                    
                    break;
                    
                case 2:
                    //INGRESE CÓDIGO CORRESPONDIENTE A LA OPCIÓN 2
                    int f = 0;
                    String n = JOptionPane.showInputDialog(null, "INGRESE UN NUEVO Nombre");
                    double p = Double.parseDouble(JOptionPane.showInputDialog(null, "INGRESE UN NUEVO Precio"));
                    int s = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE UN NUEVO Stock"));

                    for (int i = 0;  arrayProductos[i] != null; i++) {
                        f++;
                    }
                    
                    arrayProductos[f] = new Producto(n,p,s);
                    
                    
                    break;
                    
                case 3:
                    //INGRESE CÓDIGO CORRESPONDIENTE A LA OPCIÓN 3
                    int largoP3 = 0;
                    String listaP3 = "";
                    int opc3 = 0;
                    
                    for (int i = 0; arrayProductos[i] != null ; i++) {
                        largoP3++;
                        listaP3 += "\n" + (i + 1) + ". " + arrayProductos[i].getNombre();
                    }
                    
                    do {
                        opc3 = Integer.parseInt(JOptionPane.showInputDialog("Seleccione producto para ver Stock\n" + listaP3 + "\n" + (largoP3 + 1) + ". Salir" ));
                        if (opc3 > 0 && opc3 < largoP3 + 1) {
                            JOptionPane.showMessageDialog(null, "Stock: " + arrayProductos[opc3 - 1].getStock());
                        }
                        
                    } while (opc3 != largoP3 + 1);
                    
                    break;
                    
                case 4:
                    //INGRESE CÓDIGO CORRESPONDIENTE A LA OPCIÓN 4
                    String listaP4 = "";
                    int largoP4 = 0;
                    for (int i = 0; arrayProductos[i] != null; i++) {
                        largoP4++;
                        
                        if (arrayProductos[i].getStock() == 0) {
                            listaP4 += "\n" + (i+1) + "." + arrayProductos[i].getNombre();
                        }
                        
                    }
                    
                    JOptionPane.showMessageDialog(null, "PRODUCTOS SIN STOCK\n" + listaP4);
                            
                        
                    
                    break;

                    
                case 5:
                    //INGRESE CÓDIGO CORRESPONDIENTE A LA OPCIÓN 5
                    
                    String buscar2 = JOptionPane.showInputDialog(null, "CONSULTAR BOLETA POR RUT: " + "\n"
                        + "INGRESE EL RUT DEL CLIENTE");
                    for (int i = 0; arrayCompras[i] != null; i++) {

                        if (buscar2.equals(arrayCompras[i].getCliente())) {
                            
                            JOptionPane.showMessageDialog(null, "RUT: " + arrayCompras[i].getCliente() 
                                    +"\nTotal Pago: " + arrayCompras[i].getMontoTotal() 
                                    +"\nMetodo Pago: "  + arrayCompras[i].getMetodoPago()
                            );

                        }
                    }
                    break;
                    
                case 6:
                    //INGRESE CÓDIGO CORRESPONDIENTE A LA OPCIÓN 6
                    double compraTar = 0;
                    
                    for (int i = 0; arrayCompras[i]!= null; i++) {
                        
                        if (arrayCompras[i].getMetodoPago().equals("Tarjeta")) {
                            compraTar += arrayCompras[i].getMontoTotal();
                        }
                    }
                    
                    JOptionPane.showMessageDialog(null, "Dinero Recaudado por tarjeta: " + compraTar);
                    
                    break;
                    
                case 7:
                    //INGRESE CÓDIGO CORRESPONDIENTE A LA OPCIÓN 7
                
                    double compraEfe = 0;
                    
                    for (int i = 0; arrayCompras[i]!= null; i++) {
                        
                        if (arrayCompras[i].getMetodoPago().equals("Efectivo")) {
                            compraEfe += arrayCompras[i].getMontoTotal();
                        }
                    }
                    
                    JOptionPane.showMessageDialog(null, "Dinero Recaudado por Efectivo: " + compraEfe);
                    break;
                    
                case 8:
                    //INGRESE CÓDIGO CORRESPONDIENTE A LA OPCIÓN 8
                    double totalMontoTotal = 0;
                    
                    for (int i = 0; arrayCompras[i] != null; i++) {
                        totalMontoTotal += arrayCompras[i].montoTotal;
                    }
                    
                    JOptionPane.showMessageDialog(null, "Dinero recaudado: " + totalMontoTotal);
                    break;
                    
                case 9:
                    //INGRESE CÓDIGO CORRESPONDIENTE A LA OPCIÓN 9
                    System.exit(0);
                    break;    
                    
                default:
                    //INGRESE CÓDIGO CORRESPONDIENTE       
            }
        }while (op!=9);  
    }
}
