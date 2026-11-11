import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Algo {

    // Urgency from the deadline: 5 = overdue, 4 = under 1 day,
    // 3 = under 3 days, 2 = under 7 days, 1 = later than that.
    private int urgency(Taskfile t) {
        long minutesLeft = Duration.between(LocalDateTime.now(), t.getdeadline()).toMinutes();
        if (minutesLeft < 0) {
            return 5;
        } else if (minutesLeft < 24 * 60) {
            return 4;
        } else if (minutesLeft < 72 * 60) {
            return 3;
        } else if (minutesLeft < 7 * 24 * 60) {
            return 2;
        } else {
            return 1;
        }
    }

    // Score = priority (1 to 4) + urgency (1 to 5).
    // ordinal() is 0 for LOW ... 3 for URGENT, so add 1.
    // This only works if the Priority enum is declared as LOW, MEDIUM, HIGH, URGENT.
    private int score(Taskfile t) {
        int priorityScore = t.getpriority().ordinal() + 1;
        return priorityScore + urgency(t);
    }

    public void suggest(ArrayList<Taskfile> tasks, long freeMinutes) {

        // Step 1: keep only tasks that are not done.
        ArrayList<Taskfile> candidates = new ArrayList<>();
        for (Taskfile t : tasks) {
            if (t.getstatus() != Status.DONE) {
                candidates.add(t);
            }
        }
        if (candidates.isEmpty()) {
            System.out.println("No pending tasks to recommend.");
            return;
        }

        // Step 2: sort by score (highest first). If scores tie, earlier deadline first.
        candidates.sort(
            Comparator.comparingInt((Taskfile t) -> score(t)).reversed()
                .thenComparing((a, b) -> a.getdeadline().compareTo(b.getdeadline()))
        );

        // Step 3: show the top 3 and fit them into the free time.
        long remaining = freeMinutes;
        int shown = Math.min(3, candidates.size());
        System.out.println("Recommended order (" + freeMinutes + " minutes free):");

        for (int i = 0; i < shown; i++) {
            Taskfile t = candidates.get(i);
            long needed = t.getestimated_time().toMinutes();
            long minutesLeft = Duration.between(LocalDateTime.now(), t.getdeadline()).toMinutes();

            String deadlineText;
            if (minutesLeft < 0) {
                deadlineText = "OVERDUE";
            } else {
                deadlineText = (minutesLeft / 60) + " hours left";
            }

            String plan;
            if (remaining >= needed) {
                plan = "do the full task (" + needed + " min)";
                remaining = remaining - needed;
            } else if (remaining > 0) {
                int percent = (int) (100 * remaining / needed);
                plan = "partial: work " + remaining + " of " + needed + " min (" + percent + "%)";
                remaining = 0;
            } else {
                plan = "no time left for this one, do it next";
            }

            System.out.println((i + 1) + ". " + t.gettilte() + " | score " + score(t) + " | " + deadlineText);
            System.out.println("   Plan: " + plan);
        }
    }
}