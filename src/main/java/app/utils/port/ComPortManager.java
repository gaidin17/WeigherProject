package app.utils.port;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 * Created by Gaidin on 12.11.2017.
 */
public class ComPortManager implements PortManager{
    private static SerialPort serialPort;

    public ComPortManager(String portName) {
        serialPort = new SerialPort(portName);
        setupPort(serialPort);
    }

    public void startReadData() {
        boolean need_stop = false;
        System.out.println(serialPort.isOpened());
        while (serialPort.isOpened() && !need_stop) {
            try {
                System.out.println(serialPort.readString());
            } catch (SerialPortException e) {
                e.printStackTrace();
            }

        }
    }

    private void setupPort(SerialPort serialPort) {
        try {
            //Открываем порт
            serialPort.openPort();
            System.out.println(serialPort.isCTS());
            //Выставляем параметры
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            //Включаем аппаратное управление потоком
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT);
            //Устанавливаем ивент лисенер и маску
            boolean need_stop = false;
            System.out.println(serialPort.isOpened());
            while (serialPort.isOpened() && !need_stop) {
                System.out.println(serialPort.readString());

            }
            //Отправляем запрос устройству
        } catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        ComPortManager manager = new ComPortManager("COM1");
        manager.startReadData();
    }


    private static class PortReader implements SerialPortEventListener {

        public void serialEvent(SerialPortEvent event) {
            System.out.println(event);
            if (event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    //Получаем ответ от устройства, обрабатываем данные и т.д.
                    String data = serialPort.readString(event.getEventValue());


                } catch (SerialPortException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}

