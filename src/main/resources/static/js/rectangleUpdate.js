document.addEventListener("DOMContentLoaded", function () {
    const widthInput = document.querySelector('input[name="width"]');
    const heightInput = document.querySelector('input[name="height"]');
    const colorInput = document.querySelector('input[name="color"]');
    const rectangle = document.querySelector(".rectangle");
    const nameInput = document.querySelector('input[name="name"]');

    const nameDisplay = document.querySelector(".rectangle-name-display");

    function updateRectangle() {
        rectangle.style.width = widthInput.value + "px";
        rectangle.style.height = heightInput.value + "px";
        rectangle.style.backgroundColor = colorInput.value;
        rectangle.style.borderColor = colorInput.value;
        nameDisplay.textContent = nameInput.value;
    }

    // Add event listeners to the input fields
    widthInput.addEventListener("input", updateRectangle);
    heightInput.addEventListener("input", updateRectangle);
    colorInput.addEventListener("input", updateRectangle);
    nameInput.addEventListener("input", updateRectangle);
});
