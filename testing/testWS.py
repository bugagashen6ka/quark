from request import Request


request = Request('http://www.webservicex.net/stockquote.asmx/GetQuote')
request.addParameter({'symbol': 'AND'})
request.setMethod('GET')
print request.send()
