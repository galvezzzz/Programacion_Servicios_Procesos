import json
import sys

pelicula = {"El Resplandor":
    {
        "Director":"Kubrick",
        "Anyo":1980,
        "Reparto": [
            {"Nombre":"Jack Nicholson"},
            {"Nombre":"Shelley Duvall"},
            {"Nombre":"Danny Lloyd"},
            {"Nombre":"Scatman Crothers"}
        ]
    }

}

print(json.dumps(pelicula))
sys.exit(0)