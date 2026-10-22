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

log 18-09-2026
Made changes in syntax of taskmanager and added title and description editting to edittask().
decided on which dbms to use for data storage decided SqlLite for now as it less complex than MySql.

log 19-09-2026
made progress on edittask and wrote the if else script for the what task to edit. my understanding of the code and architecture seems to have improved on my part. made decisions over whether i should place the (i dont know what to call it but it is the one where the user input something but code will repromt the user till write input is put) in the classes or the program itself decided to put them on the classes it will reduce cluter and increase readabilty.

log 30-09-2026
completed edit task. next to complete the deleate and loops for inputing correct input.

log 01-10-2026
made view_task() function to veiw the task of the users choice through taskid. bug with the new function view_task() problem with compilation.

log 11-10-2026
fixed the compilation error in view_task(). completed remove task. with this the first part of the project is done. next is adding a database to this. bug with complition_time setter parameter not being recognised as the paramater and is instead identified as the object which leads to complition date not updating.
now the completion date in taskfile is behaving weird.

log 14-10-2026
fixed complition date error. it was simple enough to just set the completion date after status was set to done.
decided to use sqlite for database as it does not reqiure a server setup and can later be converted to mysql without major changes.
input validation and sanitation to be implimented

log 15-10-2026
made input_helper class to validate the inputs. now it seems there is a problem as input helper methods are not being recognized by taskmanger. also [compact source file does not have main method in the form of void main() or void main(String[] args)] this error appeared.

log 19-10-2026
completed input validation. implimented it in all of taskmanager. the issue main in input helper turned out that you cannot put declaration like formmater outside class in class file. in try catch clock while(true) block the return statement helps escape the loop.
next step is implimenting sqlite and task schedular algorithm.

log 21-10-2026
completed sqlite learning for implimenting in project. made decissions about where to start implimenting the database. still confused about some things but will handel them as they come.

log 22-10-2026
implimented sqlite to project. made the initialize method in taskdatabase class. changed taskfile removed id static counter and declared task_id as int. made a second constructor for database to use when the data is pulled from database it uses that constructor. made a setter for id for database to use.
made taskdatabase and made intilize method. changed taskmanager to accomodate the change of string task_id to int task_id. used == instead of String.valuesof(). next will make insert for taskdatabase. then handel deleate and update.