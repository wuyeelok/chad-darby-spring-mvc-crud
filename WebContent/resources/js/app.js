const deleteLinkEles = document.querySelectorAll("a.deleteLink")

if (deleteLinkEles !== undefined && deleteLinkEles !== null) {
    const deleteLinkList = [...deleteLinkEles]

    deleteLinkList.forEach(url => {
        url.addEventListener("click", event => {
            event.preventDefault();

            const urlHref = url.getAttribute("href")
            const cId = urlHref.substring(26)

            if (confirm(`Are you sure you want to delete customer with Id: ${cId}?`)) {
                window.location.href = urlHref
            }
        });
    })
}