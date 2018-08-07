/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.JOptionPane;

/**
 *
 * @author alamv
 */
public class PontuacaoBoliche {

    public void calculapontos() {

        String qtpinos;
        int Total = 0;
        int ii = 0;
        int n = 21;
        boolean q = false;

        String[] pontos = new String[21];
        Integer[] pontosT = new Integer[10];

        for (int i = 0; i < n; i++) {
            boolean te = false;
            
            while (te == false) {
                try {
                    String pon = JOptionPane.showInputDialog("Informe a Quantidade de Pinos derrubados na jogada " + (i + 1));

                    if (pon.equalsIgnoreCase("x") || pon.equalsIgnoreCase("/") || Integer.parseInt(pon) < 10) {
                        te = true;
                        if (pon.equalsIgnoreCase("x")) {

                            if (i < 18) {
                                pontos[i] = pon;
                                i++;
                            } else {
                                pontos[i] = pon;
                            }

                        } else {

                            pontos[i] = pon;
                        }

                        if (!pon.equalsIgnoreCase("x") && i > 18 && i < 20) {
                            n--;
                        }
                        if (n == 20) {
                            q = true;
                        }
                    } else if (Integer.parseInt(pon) > 10) {
                        JOptionPane.showMessageDialog(null, "Erro ! Informe a quantidade correta de Pinos derrubados");

                    } else if (pon.length() >= 2) {
                        JOptionPane.showMessageDialog(null, "Erro! Informe somente um carectere");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro!");
                    }

                } catch (NullPointerException e) {
                    
                    System.exit(0);

                }catch(NumberFormatException ee){
                    JOptionPane.showMessageDialog(null, "Erro! Declaração de Pontos Incorreta");
                }
            }
        }

        int cont2 = 1;

        for (int i = 0; i < n; i++) {
            int cont = 0;
            int cont1 = 1;

            try {

                if (pontos[i].equalsIgnoreCase("x")) {
                    Total = Total + 10;
                    do {

                        if (pontos[i + cont1] != null) {

                            if (i < 18) {

                                Total = Total + Integer.parseInt((pontos[i + cont1].equalsIgnoreCase("x")) ? "10" : (pontos[i + cont1].equalsIgnoreCase("/")) ? String.valueOf(10 - Integer.parseInt(pontos[i + (cont1 - 1)])) : pontos[i + cont1]);

                                cont++;
                            } else {

                                //Total = Total + Integer.parseInt((pontos[i].equalsIgnoreCase("x")) ? "10" : (pontos[i].equalsIgnoreCase("/")) ? String.valueOf(10-Integer.parseInt(pontos[i])): "10");
                                //cont++;
                            }

                        }
                        cont1++;

                    } while (cont != 2);
                    pontosT[ii] = Total;

                }

                if (!pontos[i].equalsIgnoreCase("x") && !pontos[i].equals("/") && i < 18) {
                    Total = Total + Integer.parseInt(pontos[i]) + Integer.parseInt((pontos[i + 1].equalsIgnoreCase("/")) ? String.valueOf(10 - Integer.parseInt(pontos[i])) : pontos[i + 1]);

                    if (!pontos[i + 1].equals("/")) {

                        pontosT[ii] = Total;
                        i++;
                        ii++;
                        cont2++;
                        continue;
                    }

                }
                if (i >= 18 && !pontos[i].equalsIgnoreCase("x") && !pontos[i].equals("/") && q == true) {
                    Total = Total + Integer.parseInt(pontos[i]) + Integer.parseInt((pontos[i + 1].equalsIgnoreCase("/")) ? String.valueOf(10 - Integer.parseInt(pontos[i])) : pontos[i + 1]);

                    pontosT[ii] = Total;

                }
                if (i > 18 && !pontos[i].equalsIgnoreCase("x") && !pontos[i].equals("/") && q == false) {
                    Total = Total + Integer.parseInt(pontos[i]);
                    pontosT[ii] = Total;
                }

                if (pontos[i].equalsIgnoreCase("/")) {

                    do {

                        if (pontos[i] != null) {

                            //String ee = String.valueOf(10-Integer.parseInt(pontos[i-1]));
                            Total = Total + Integer.parseInt(pontos[i + 1].equalsIgnoreCase("x") ? "10" : pontos[i + 1]);
                            // tem que colocar para converter "/" para ele somar
                            cont++;

                            if (pontosT[ii] != null) {
                                pontosT[ii] = Total;
                            }

                        }
                        if (i > 18) {
                            cont = 1;
                        }

                        //cont1++;
                    } while (cont != 1);

                }

                if (cont2 % 2 == 0) {

                    pontosT[ii] = Total;

                }
                if (pontosT[ii] != null) {
                    ii++;
                }

            } catch (Exception er) {
                // e.printStackTrace();
            }
            cont2++;

        }
        for (Integer pont : pontosT) {
            System.out.println(pont);
        }
        // quando o ultimo é "/" ele nao soma
    }
}
