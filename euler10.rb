total = 0

primes = Array.new
def isprime(a)
#simple function to determine if a number is prime - which is only divisible by one
#and itself
b = a
b -= 1
c = 0
d = 0

while  b != 1 do
    if  a <= 1
        b = 1
        d = 1
    elsif a % b == 0
        c += 1
        b = 1
    else
        b -= 1
    end
end

if d == 1
    return false
elsif c > 0
   return false
else
    return true
end
end

2000000.times do |x|
	puts x
	if isprime(x) == true
		total += x
	end
end

puts total