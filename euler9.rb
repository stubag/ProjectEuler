x = 0
y = 0
z = 0
c = 997
a = 1
condition = 0
answer = 0
total = 0


while condition < 1000
	b = 1000 - (a+c)
	y = b
	z = c
		while y < z
			total += 1
			z -= 1
			y += 1
			x = 1000 - (z+y)
			d = (a**2) + (y**2)
			if d == (z**2)
				a = x
				b = y
				c = z
				answer = a * b * c
				condition = 1001
				break
				
			end
		end



a += 1
c -= 1
condition += 1
end

puts "a: #{a-1}, b: #{b}, c: #{c+1}"
puts "The product of a*b*c is #{answer}"
puts total