{
  "type": "object",
  "$schema": "http://json-schema.org/draft-03/schema",
  "id": "http://jsonschema.net",
  "required": true,
  "properties": {
    "id": {
      "type": "number",
      "required": true
    },
    "name": {
      "type": "string",
      "required": true,
      "minLength": 4,
      "maxLength": 128
    }
  }
}