Scanner estimated_time_input = new Scanner(System.in);
    System.err.print("Please enter the estimated time you want to change to: ");
    int hours= estimated_time_input.nextInt();
    Duration estimated_time = Duration.ofHours(hours);
    t.setestimated_time(estimated_time);



System.out.print("Choose an option: ");

int choice = editchoice.nextInt();
editchoice.nextLine(); // clears leftover newline after nextInt() — remember this gotcha from earlier

if (choice == 1) {
    System.out.print("Enter new title: ");
    String newTitle = editchoice.nextLine();
    t.setTitle(newTitle);
} else if (choice == 2) {
    System.out.print("Enter new description: ");
    String newDescription = editchoice.nextLine();
    t.setDescription(newDescription);
} else if (choice == 3) {
    System.out.print("Enter new priority (LOW, MEDIUM, HIGH, URGENT): ");
    String newPriority = editchoice.nextLine();
    t.setPriority(Priority.valueOf(newPriority.toUpperCase()));
} else if (choice == 4) {
    System.out.print("Enter new category (WORK, STUDY, EXPENSES, OTHERS): ");
    String newCategory = editchoice.nextLine();
    t.setCategory(Category.valueOf(newCategory.toUpperCase()));
} else if (choice == 5) {
    System.out.print("Enter new deadline (dd-MM-yyyy HH-mm): ");
    String newDeadlineInput = editchoice.nextLine();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");
    t.setDeadline(LocalDateTime.parse(newDeadlineInput, formatter));
} else if (choice == 6) {
    System.out.print("Enter new estimated duration in hours: ");
    int newHours = editchoice.nextInt();
    t.setEstimatedDuration(Duration.ofHours(newHours));
} else if (choice == 7) {
    System.out.print("Enter new status (TODO, IN_PROGRESS, DONE, OVERDUE): ");
    String newStatus = editchoice.nextLine();
    t.setStatus(Status.valueOf(newStatus.toUpperCase()));
} else if (choice == 8) {
    System.out.println("Edit cancelled.");
} else {
    System.out.println("INVALID CHOICE.");
}