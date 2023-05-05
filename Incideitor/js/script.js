    let wall = document.getElementById("wall_dos");

     window.addEventListener('scroll',function(){
        var value = window.scrollY;
        wall.style.bottom = value * 0.05 + 'px';
        
     
    })


