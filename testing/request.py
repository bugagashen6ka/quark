import requests
from requests.auth import HTTPBasicAuth

class Request(object):
	"""docstring for Request"""


	def __init__(self, url):
		self.url = url
		self.payload = {}
		self.auth = False


	def send(self):
		try:
			if self.method == 'GET':
				if self.auth:
					r = requests.get(self.url, params=self.payload, auth=HTTPBasicAuth(self.user, self.password))
				else:
					r = requests.get(self.url, params=self.payload)
			elif self.method == 'POST':
				if self.auth:
					r = requests.post(self.url, data=self.payload, auth=HTTPBasicAuth(self.user, self.password))
				else:
					r = requests.post(self.url, data=self.payload)
			else:
				return "Method is not defined"
			self.lastResponce = r.text
		except Exception as ex:
			self.lastResponce = ex.__str__
		return self.lastResponce

	def basicAuth(self, user, password):
		self.user = user
		self.password = password
		self.auth = True

	def getLastResponce(self):
		return self.lastResponce

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




		