Here is the updated `README.md` with the explanations introduced in a professional format:

```markdown
# Task Management CLI Application

This is a command-line application for managing tasks. It allows you to add, update, delete, mark tasks with specific statuses, and list tasks with optional filters.

## Prerequisites

- **Java**: Ensure you have Java 8 or later installed.
- **Maven**: Ensure Maven is installed for building the project.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/task-manager.git
   cd task-manager
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Navigate to the `target` directory:
   ```bash
   cd target
   ```

4. Run the program:
   ```bash
   java -jar task-manager.jar <command> [parameters]
   ```

## Commands and Parameters

### 1. **add**
- **Description**: Adds a new task with a description.
- **Usage**:
  ```bash
  java -jar task-manager.jar add "<description>"
  ```
- **Example**:
  ```bash
  java -jar task-manager.jar add "Complete the project documentation"
  ```

### 2. **update**
- **Description**: Updates the description of an existing task by its ID.
- **Parameters**:
    - `id`: The ID of the task to update.
    - `description`: The new description for the task.
- **Usage**:
  ```bash
  java -jar task-manager.jar update <id> "<description>"
  ```
- **Example**:
  ```bash
  java -jar task-manager.jar update 1 "Update the project timeline"
  ```

### 3. **delete**
- **Description**: Deletes a task by its ID.
- **Parameters**:
    - `id`: The ID of the task to delete.
- **Usage**:
  ```bash
  java -jar task-manager.jar delete <id>
  ```
- **Example**:
  ```bash
  java -jar task-manager.jar delete 2
  ```

### 4. **mark-in-progress**
- **Description**: Marks a task as "in-progress" by its ID.
- **Parameters**:
    - `id`: The ID of the task to mark.
- **Usage**:
  ```bash
  java -jar task-manager.jar mark-in-progress <id>
  ```
- **Example**:
  ```bash
  java -jar task-manager.jar mark-in-progress 3
  ```

### 5. **mark-done**
- **Description**: Marks a task as "done" by its ID.
- **Parameters**:
    - `id`: The ID of the task to mark.
- **Usage**:
  ```bash
  java -jar task-manager.jar mark-done <id>
  ```
- **Example**:
  ```bash
  java -jar task-manager.jar mark-done 1
  ```

### 6. **list**
- **Description**: Lists all tasks or filters tasks by status.
- **Parameters**:
    - `filter` (optional): Filter tasks by status (`todo`, `in-progress`, `done`).
- **Usage**:
  ```bash
  java -jar task-manager.jar list [filter]
  ```
- **Examples**:
    - List all tasks:
      ```bash
      java -jar task-manager.jar list
      ```
    - List tasks with status "done":
      ```bash
      java -jar task-manager.jar list done
      ```

## Error Handling

- If an invalid command or parameter is provided, the program will display an appropriate error message.
- If the input string for a task ID is not a valid integer, the program will display:  
  `Error: The input string is not a valid integer.`
- Ensure that the `tasks.json` file is in the same directory as the `task-manager.jar` file.

## Supported Operating Systems

The application is platform-independent and can be run on the following operating systems:

- **Windows**:
    - Open Command Prompt or PowerShell and execute the commands as shown above.
- **macOS**:
    - Open Terminal and execute the commands as shown above.
- **Linux**:
    - Open a terminal and execute the commands as shown above.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
```

This version includes professional explanations for error handling and usage across operating systems.