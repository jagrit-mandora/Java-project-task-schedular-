project logs:

earlier from 15-08-2026:
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

log 17-08-2026
work done today
==made taskmanager class to handel things like add task , remove task, etc

log 02-09-2026
troubleshoot the issue with addtaskinput not add the taskfile object to arraylist.
problem with declaration of static and non static in classes. removed static keyword from all but main
and changed the calling of all fuctions to that of a non static method.
learnt about the diffrence in static and non static. 
refrenced :https://www.geeksforgeeks.org/java/difference-between-static-and-non-static-method-in-java/,
https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context,
claude

log 03-09-2026 to  07-09-2026
tried to print the the all the tasks the from the arraylist but failed a few times. now am refrecing claude to find the error in the code. 
made changes to the main program so it now calls the the taskmanager class only one time outside the menu loop before the program starts.

log 09-09-2026
succeded in making the showtask() it now allows to veiw all the tasks. used a for loop to navigate the task array. then called the value using task.get(i) then printed the value at that index.
started making the edittask() leaning in the direction of iterating over the array then change the value to be changed using set.

log 10-09-2026
worked on edittask() finally properly started using earlier get and set made in taskfile. brain strommed about the solution of edit that will work but the solution is not found yet. 
made changed in main class menu to incoperate edittask.

log 11-09-2026
worked on edittask() can properly navigate to the entry or task the user wants to change but there is a bug with setters in taskfile that are causing problem . there is also a issue of int and duration conversion.

log 12-09-2026
completed the edittask(). Debugged estimated time part. the problem was syntax with duration data type conversion which should have used Duration.ofHours() to convert int to duration. 
working on rest of the entries . they are fairly simpple as the logic is fairly unserstood.
