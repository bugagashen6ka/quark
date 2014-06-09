import requests

class Request(object):
	"""docstring for Request"""


	def __init__(self, url):
		self.url = url
		self.payload = {}


	def send(self):
		if self.method == 'GET':
			r = requests.get(self.url, params=self.payload)
		elif self.method == 'POST':
			r = requests.post(self.url, data=self.payload)
		else:
			return "Method is not defined"
		return r.text

	def addParameter(self, param):
		self.payload.update(param)

	def getPayload(self):
		return self.payload	


	def setURL(self, url):
		self.url = ulr

	def getULR(self):
		return self.url
	
	def setMethod(self, method):
		self.method = method

	def getMethod(self):
		return self.method




		