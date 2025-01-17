Overview:

Develop a Task Management System that allows users to manage their daily tasks. The system should enable users to create, view, update, and delete tasks, subtasks and stories within a project. Each task, subtask (tasks can have multiple subtasks) and a story (story can have multiple tasks) can have a description, deadline, and assigned user.

Mandatory Functionality:

Registration and Login: Users can register and log in to the system.
Task Management:
Create new tasks with a description and deadline.
View a list of tasks assigned to the logged-in user.
Update tasks, including changing the description, deadline, and status.
Delete tasks.
Allow tasks, subtasks, and stories to be moved across the project hierarchy, including their dependent items.
Get the current workload of a user
Number of tasks in different states like assigned, pending, etc.
Functions to help you think-

createTask(title, description, deadline): Creates a new task with the given details.

createSubtask(parentTaskId, title, description, deadline): Adds a subtask to an existing task.

createStory(title, description, tasks): Groups tasks together into a story.

moveTask(taskId, newParentId): Moves a task or subtask under a different parent task or story, handling dependencies.

getUserWorkload(userId): Retrieves the current workload for the specified user, including tasks and deadlines.
