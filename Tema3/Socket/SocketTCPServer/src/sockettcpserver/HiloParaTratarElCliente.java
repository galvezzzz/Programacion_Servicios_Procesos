/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockettcpserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Alberto
 */
public class HiloParaTratarElCliente {
    Socket cs;
    public HiloParaTratarElCliente (Socket cs) {
        this.cs = cs;
    }
    public void run() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(cs.getOutputStream());
        // y el resto de tu codigo
   }
}
