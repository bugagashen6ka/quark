from request import Request


# request = Request('http://www.webservicex.net/stockquote.asmx/GetQuote')
# request.addParameter({'symbol': 'AND'})
# request.setMethod('GET')
# print request.send()

print 'Using port 8080'
request = Request('http://127.0.0.1:8080/ams-quark-1-web/ws/echo.json')
request.basicAuth('quark@at.net', '1')
request.addParameter({
    "rid": 5,
    "email": "apfel",
    "password": "1",
    "firstName": "Apfel",
    "lastName": "Saft",
    "title": "Prof.",
    "phoneNumber": "1111",
    "createdGroups": None,
    "createdAppointments": None,
    "appointments": None
})
request.setMethod('POST')

responce = '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><researcher><email>apfel</email><firstName>Apfel</firstName><lastName>Saft</lastName><password>1</password><phoneNumber>1111</phoneNumber><rid>5</rid><title>Prof.</title></researcher>'
if request.send() == responce:
	print "Correct responce"
else:
	print "Error occured:"
	print "=> " + request.lastResponce()


