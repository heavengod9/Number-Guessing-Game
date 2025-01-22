import random
import time

def display_welcome_message():
    print("Welcome to the Number Guessing Game!")
    print("I'm thinking of a number between 1 and 100.")
    print("You have to guess the correct number based on the difficulty level you choose.\n")

def select_difficulty():
    print("Please select the difficulty level:")
    print("1. Easy (10 chances)")
    print("2. Medium (5 chances)")
    print("3. Hard (3 chances)")
    while True:
        try:
            choice = int(input("Enter your choice: "))
            if choice == 1:
                return 10
            elif choice == 2:
                return 5
            elif choice == 3:
                return 3
            else:
                print("Invalid choice! Please enter 1, 2, or 3.")
        except ValueError:
            print("Please enter a valid number.")

def play_game():
    high_score = None
    while True:
        display_welcome_message()
        chances = select_difficulty()
        number = random.randint(1, 100)
        print(f"\nGreat! You have selected a difficulty level with {chances} chances.")
        print("Let's start the game!\n")
        
        start_time = time.time()
        attempts = 0
        hints_used = 0
        
        while chances > 0:
            try:
                guess = int(input("Enter your guess: "))
                attempts += 1
                if guess == number:
                    elapsed_time = round(time.time() - start_time, 2)
                    print(f"\nCongratulations! You guessed the correct number {number} in {attempts} attempts.")
                    print(f"Time taken: {elapsed_time} seconds.\n")
                    if high_score is None or attempts < high_score:
                        high_score = attempts
                        print("New high score!")
                    break
                elif guess < number:
                    print("Incorrect! The number is greater than your guess.")
                else:
                    print("Incorrect! The number is less than your guess.")
                
                chances -= 1
                if chances > 0:
                    print(f"You have {chances} chances left.")
                    if input("Need a hint? (y/n): ").lower() == 'y':
                        hints_used += 1
                        if abs(number - guess) <= 10:
                            print("Hint: You're very close!")
                        else:
                            print("Hint: The number is far from your guess.")
            except ValueError:
                print("Please enter a valid number.")
        
        if chances == 0 and guess != number:
            print(f"\nOut of chances! The correct number was {number}.\n")
        
        print(f"High Score: {high_score} attempts.")
        if input("Do you want to play again? (y/n): ").lower() != 'y':
            print("Thank you for playing! Goodbye!")
            break

if __name__ == "__main__":
    play_game()
