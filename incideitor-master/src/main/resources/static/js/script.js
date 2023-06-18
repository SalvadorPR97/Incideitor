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
        // Establecemos la direccion de la ordenación a ascendente:
        dir = "asc";
        /* Make a loop that will continue until
        no switching has been done: */
        while (switching) {
            // Start by saying: no switching is done:
            switching = false;
            rows = table.rows;
            /* Loop through all table rows (except the
            first, which contains table headers): */
            for (i = 1; i < (rows.length - 1); i++) {
                // Start by saying there should be no switching:
                shouldSwitch = false;
                /* Get the two elements you want to compare,
                one from current row and one from the next: */
                x = rows[i].getElementsByTagName("TD")[n];
                y = rows[i + 1].getElementsByTagName("TD")[n];
                /* Check if the two rows should switch place,
                based on the direction, asc or desc: */

                if (dir == "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                }
            }
            if (shouldSwitch) {
                /* If a switch has been marked, make the switch
                and mark that a switch has been done: */
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
                // Each time a switch is done, increase this count by 1:
                switchcount++;
            } else {
                /* If no switching has been done AND the direction is "asc",
                set the direction to "desc" and run the while loop again. */
                if (switchcount == 0 && dir == "asc") {
                    dir = "desc";
                    switching = true;
                }
            }
        }
    }
