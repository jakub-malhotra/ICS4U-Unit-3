# frozen_string_literal: true

# Program to calculate factorial using recursion.
# @author Jakub Malhotra
# @version 1.0
# @since   2024-11-20

# Recursively preforms factorial calculations 
# @param number_to_factorial [Int] The string to be reversed.
# @return [String] The reversed string.
def calculate_factorial(number_to_factorial)
  # return -1 for error case
  if number_to_factorial < 0
    return -1
  end
  # base case and 0 case
  if number_to_factorial == 1 || number_to_factorial == 0
    return 1
  end

  lower_number = number_to_factorial -1

  # Multiply the lower number by the current number
  calculate_factorial(lower_number) * number_to_factorial
end

# The main logic
puts "Enter a positive integer:"
userInput = gets.chomp.to_i

puts ""
the_product = calculate_factorial(userInput)
if the_product == -1
  puts "Invalid input"
else
  puts "#{userInput}! = #{the_product}"
end

puts "\nDone."
