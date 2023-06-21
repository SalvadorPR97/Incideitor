    // Registro Usuario:
    // Comprobación de que las contraseñas coinciden
    function validarFormulario() {
        var password = document.getElementById("contrasena").value;
        var confirmPassword = document.getElementById("confirmarContrasena").value;

        if (password !== confirmPassword) {
            alert("Las contraseñas no coinciden");
            return false; // Evita enviar el formulario
        }

        return true; // Permite enviar el formulario
    }

    // Registro Incidencia:
    // Genera la sublista de tipos de incidencias
    function recargarPagina(valorSeleccionado) {
        // Redirigir a la misma página con el parámetro seleccionado
        var valorSeleccionado = document.getElementById("incidenciaPadre").value;
        window.location.href = window.location.pathname + '?incidenciaPadre=' + valorSeleccionado;
    }

    // Login:
    // Alterna entre mostrar o no la contraseña
    document.querySelector('#view').addEventListener('click', e => {
        const passwordInput = document.querySelector('#password');
        if (e.target.classList.contains('show')) {
            e.target.classList.remove('show');
            passwordInput.type = 'text';
            view.style.opacity = 0.8
        } else {
            e.target.classList.add('show');
            passwordInput.type = 'password';
            view.style.opacity = 0.2
        }
    });

    // Tablas:
    // Script para ordenar los valores de las tablas
    function sortTable(n) {
        var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
        table = document.getElementById("tablaOrdenar");
        switching = true;
        // Establecemos la dirección de la ordenación como ascendente:
        dir = "asc";
        /* Hacemos un bucle que continuará hasta que no se cambie el valor de switching: */
        while (switching) {
            // Comenzamos diciendo que no se ha realizado ningún switch:
            switching = false;
            rows = table.rows;
            /* Recorremos todas las filas de la tabla (excepto la primera, que contiene los encabezados de la tabla): */
            for (i = 1; i < (rows.length - 1); i++) {
                // Comenzamos diciendo que no debería haber switch:
                shouldSwitch = false;
                /* Obtenemos los dos elementos que queremos comparar,
                uno de la fila actual y otro de la siguiente: */
                x = rows[i].getElementsByTagName("TD")[n];
                y = rows[i + 1].getElementsByTagName("TD")[n];
                /* Comprobamos si las dos filas deben intercambiarse de lugar,
                en función de la dirección, ascendente o descendente: */

                if (dir == "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        // Si es así, marcamos como un switch y rompemos el bucle:
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        // Si es así, marcamos como un switch y rompemos el bucle:
                        shouldSwitch = true;
                        break;
                    }
                }
            }
            if (shouldSwitch) {
                /* Si se ha marcado un switch, realizamos el intercambio
                y marcamos que se ha realizado un intercambio: */
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
                // Cada vez que se realiza un intercambio, aumentamos esta cuenta en 1:
                switchcount++;
            } else {
                /* Si no se ha realizado ningún switch Y la dirección es "asc",
                establecemos la dirección como "desc" y ejecutamos el bucle while nuevamente. */
                if (switchcount == 0 && dir == "asc") {
                    dir = "desc";
                    switching = true;
                }
            }
        }
    }

    // Inicialización del mapa y autocompletado
    function initMap() {
        const map = new google.maps.Map(document.getElementById('map'), {
            center: { lat: 36.596470, lng: -4.637029 },
            zoom: 12
        });

        const input = document.getElementById('address-input');
        const autocomplete = new google.maps.places.Autocomplete(input);
        autocomplete.bindTo('bounds', map);

        const marker = new google.maps.Marker({
            map,
            anchorPoint: new google.maps.Point(0, -29)
        });

        autocomplete.addListener('place_changed', () => {
            marker.setVisible(false);
            const place = autocomplete.getPlace();

            if (!place.geometry) {
                window.alert('No se encontró la dirección ingresada');
                return;
            }

            if (place.geometry.viewport) {
                map.fitBounds(place.geometry.viewport);
            } else {
                map.setCenter(place.geometry.location);
                map.setZoom(17);
            }

            marker.setPosition(place.geometry.location);
            marker.setVisible(true);
        });
    }


