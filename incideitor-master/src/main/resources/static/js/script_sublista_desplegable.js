function crearListaDesplegable() {
    var seleccion = document.getElementById("tipo_incidencia");
    var opcionSeleccionada = seleccion.options[seleccion.selectedIndex].text;
            
    if (!document.getElementById("listaDesplegable")) {
        var nuevaListaDesplegable = document.createElement("select");
        nuevaListaDesplegable.id = "listaDesplegable";
        nuevaListaDesplegable.onchange = crearListaDesplegable;

        var opcionDefault = document.createElement("option");
        opcionDefault.text = "Selecciona subtipo de incidencia";
        nuevaListaDesplegable.add(opcionDefault);
                
        var opciones = seleccion.getElementsByTagName("option");
        for (var i = 0; i < opciones.length; i++) {
        var opcion = document.createElement("option");
        opcion.text = opciones[i].text;
        nuevaListaDesplegable.add(opcion);
        }
                
        var contenedor = document.getElementById("contenedor");
        contenedor.appendChild(nuevaListaDesplegable);
            }
        }