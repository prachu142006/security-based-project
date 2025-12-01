import re

def check_password_strength(password):
    score = 0

    # Length check
    if len(password) >= 8:
        score += 1
    
    # Uppercase
    if re.search(r"[A-Z]", password):
        score += 1

    # Lowercase
    if re.search(r"[a-z]", password):
        score += 1

    # Numbers
    if re.search(r"[0-9]", password):
        score += 1

    # Special characters
    if re.search(r"[@#$%^&*()_+=!?<>]", password):
        score += 1

    # Final strength categorization
    if score <= 2:
        return "Weak Password"
    elif score == 3:
        return "Medium Password"
    elif score == 4:
        return "Strong Password"
    else:
        return "Very Strong Password"


# Main program
pwd = input("Enter your password: ")
print("Password Strength:", check_password_strength(pwd))
