package scheduler;

import com.sun.org.apache.bcel.internal.classfile.Unknown;
import org.junit.Test;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@Component
public class ScheduledTasks {

    @Inject
    EmailService emailService;
    @Inject
    Service service;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void run() throws Exception {
        try {
            System.out.println("Iniciado em " + dateFormat.format(new Date()));
            String result = service.get(null);
            System.out.println("retorno :" + result);
            emailService.sendEmail(result);
            System.out.println("Finalizado em " + dateFormat.format(new Date()));
        } catch (UnknownHostException e) {
            System.out.println("Provavel mente a net caiu :" + e.getMessage());
        }catch (Exception e) {
            System.out.println("ERRO" + e.getMessage());
        }
    }
}