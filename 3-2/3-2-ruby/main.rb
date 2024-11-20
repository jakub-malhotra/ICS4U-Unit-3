# frozen_string_literal: true

# Program to reverse a string using recursion.
# @author Jakub Malhotra
# @version 1.0
# @since   2024-11-18

# Recursively reverses a string.
# @param string_to_reverse [String] The string to be reversed.
# @return [String] The reversed string.
def reverse_string(string_to_reverse)
  if string_to_reverse == ''
    return ''
  end

  first_character = string_to_reverse[0]
  rest_of_string = string_to_reverse[1..]

  # Reverse the rest of the string and append the first character.
  reverse_string(rest_of_string) + first_character
end

# The main logic
a_string = 'racecar'

puts "\nThe original string is: #{a_string}"
reversed_string = reverse_string(a_string)
puts "The reversed string is: #{reversed_string}"

puts "\nDone."
