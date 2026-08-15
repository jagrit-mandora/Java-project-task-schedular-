project logs:

15-08-2026:
work done earlier form this date.
==First made three new types called category, priority and status using enum because later we need to apply a algorithm to priorities tasks and having some predefined types are better.
==Then made file named taskfile to call later in main. in this file declared taskid, title, description, priority, category, status. to have user later enter these values.
==Then faced my first problem of having deadline, creation date, estimated time and completion date. referenced: https://www.geeksforgeeks.org/java/java-time-localdatetime-class-in-java/.
and decided to use Localdatetime for deadline and completion , localdate for creation date and duration for estimated time.

log 15-08-2026
work done today
==made setters to prep for taskmanager which will have all the funtionality to edit, deleate, etc
==code was getting too wide so split the code using plus of next line enter.
==to get the user to enter the input used scanner. refrenced https://www.w3schools.com/java/java_user_input.asp
== every task needs a unique task_id. refrenced https://www.baeldung.com/java-create-unique-random-identifiers . had the option of using uuid but ended up using the simple approch of using a counter as 
keeping a track of uuid generated id is weird and will not look good in a task schedular.
== to use the date value input by user in the task. i needed to convert the date value to localdatetime as scanner does not have localdatetime in my knowleadge. so used datetimeformatter.
refrenced https://www.geeksforgeeks.org/java/convert-string-to-localdate-in-java/


