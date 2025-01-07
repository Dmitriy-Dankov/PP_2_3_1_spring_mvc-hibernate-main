
function sendInput(from, to) {
    from.parentNode.parentNode.querySelector(to).value = from.value;
}