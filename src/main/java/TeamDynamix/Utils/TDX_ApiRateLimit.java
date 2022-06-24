package TeamDynamix.Utils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TDX_ApiRateLimit {

    private Instant resetTime;
    private int currentCallNumber;
    private int maxCalls;
    private int period;

    public TDX_ApiRateLimit(int maxCalls, int seconds) {
        this.resetTime = Instant.now();
        this.currentCallNumber = 0;
        this.maxCalls = maxCalls;
        this.period = seconds;
    }

    public void CheckRateLimit() {
//        System.out.println("Checking Rate Limit at " +
//                Instant.now() +
//                ". Count is now: " +
//                currentCallNumber +
//                ". Reset time is " +
//                resetTime +
//                ".");

        if (resetTime.isBefore(Instant.now())) {
            currentCallNumber = 0;
            resetTime = Instant.now().plus(Duration.ofSeconds(period));
        }

        currentCallNumber++;
        if ((currentCallNumber > maxCalls) && (resetTime.isAfter(Instant.now()))) {
            try {
//                System.out.println("Sleep time is: " + Duration.between(Instant.now(), resetTime).toMillis());
                Thread.sleep(Duration.between(Instant.now(), resetTime).toMillis());

            } catch (InterruptedException interruptedException) {
                System.out.println("ERROR: Interrupted Exception:\n\n" +
                        interruptedException);
            }
            currentCallNumber = 1;
            resetTime = Instant.now().plus(Duration.ofSeconds(period+1));
        }

//        System.out.println("Check completed at " +
//                Instant.now() +
//                ". Count is now: " +
//                currentCallNumber +
//                ". Reset time is " +
//                resetTime +
//                ".");

    }

    public void forceCheck() {
        currentCallNumber += 1;
        resetTime = Instant.now().plus(Duration.ofSeconds(period+1));
    }
}
