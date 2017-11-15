package app.utils.port;

import app.utils.port.decoding.decoder.Decoder;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Gaidin on 12.11.2017.
 */
@Component
public class ComPortManager implements PortManager{
    @Autowired
    private Decoder<Double, String> decoder;
    private static SerialPort serialPort;

    @PostConstruct
    public void init() {
        serialPort = new SerialPort("COM1");
        setupPort(serialPort);
    }

    @SuppressWarnings("unckecked")
    public void startReadData() {
        boolean need_stop = false;
        System.out.println(serialPort.isOpened());
        Double result = null;
        while (serialPort.isOpened() && !need_stop) {
            try {
                result = decoder.decode(serialPort.readString());
            } catch (SerialPortException e) {
                e.printStackTrace();
            }
            if (result != null) {
                System.out.println(result);
                need_stop = true;
            }

        }
    }

    private void setupPort(SerialPort serialPort) {
        try {
            serialPort.openPort();
            System.out.println(serialPort.isCTS());
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT);
        } catch (SerialPortException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static class PortReader implements SerialPortEventListener {

        public void serialEvent(SerialPortEvent event) {
            System.out.println(event);
            if (event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    String data = serialPort.readString(event.getEventValue());
                } catch (SerialPortException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

}

