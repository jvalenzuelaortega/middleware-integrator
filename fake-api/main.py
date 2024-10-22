from flask import Flask, jsonify, request
import json

app = Flask(__name__)

with open('data.json', 'r') as file:
    data = json.load(file)

@app.route('/get-assistance-by-company', methods=['GET'])
def get_users():
    return jsonify(data['empresa'])


if __name__ == '__main__':
    app.run(debug=True)