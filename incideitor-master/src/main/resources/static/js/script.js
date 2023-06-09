    let wall = document.getElementById("wall_dos");

     window.addEventListener('scroll',function(){
        var value = window.scrollY;
        wall.style.bottom = value * 0.05 + 'px';
        
     
    })

    function recargarPagina(valorSeleccionado) {
        // Redirigir a la misma página con el parámetro seleccionado
        var valorSeleccionado = document.getElementById("incidenciaPadre").value;
        window.location.href = window.location.pathname + '?incidenciaPadre=' + valorSeleccionado;
    }


