const apiUrl = 'http://localhost:3001';

const formatDate = (day, month, year, time) => {
    return `${year}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}T${time}:00`;
};

const displayFlightDetails = (flight, containerId, clear = false) => {
    const container = document.getElementById(containerId);
    if (clear) {
        container.innerHTML = ''; // Clear previous content if clear is true
    }

    const flightCard = document.createElement('div');
    flightCard.className = 'flight-card';
    flightCard.innerHTML = `
        <div class="flight-header">
            <p><strong>Flight ID:</strong> ${flight.flightId}</p>
            <p><strong>Price:</strong> $${flight.price.toFixed(2)}</p>
        </div>
        <div class="flight-details">
            <p><strong>Origin:</strong> ${flight.flightOrigin}</p>
            <p><strong>Destination:</strong> ${flight.flightDestination}</p>
            <p><strong>Departure Time:</strong> ${new Date(flight.flightDepartureTime).toLocaleString('en-GB')}</p>
            <p><strong>Arrival Time:</strong> ${new Date(flight.flightArrivalTime).toLocaleString('en-GB')}</p>
            <p><strong>Capacity:</strong> ${flight.capacity}</p>
        </div>
    `;
    container.appendChild(flightCard);
};

async function getFlights() {
    try {
        const response = await fetch(`${apiUrl}/flights`);
        const data = await response.json();
        const flightsContainer = document.getElementById('flightsContainer');
        flightsContainer.innerHTML = ''; // Clear previous content

        // Sort flights by flightId
        data.sort((a, b) => a.flightId - b.flightId);

        data.forEach(flight => {
            displayFlightDetails(flight, 'flightsContainer');
        });
    } catch (error) {
        console.error('Error fetching flights:', error);
    }
}

function toggleFlights() {
    const flightsContainer = document.getElementById('flightsContainer');
    const toggleButton = document.getElementById('toggleFlightsButton');

    if (flightsContainer.style.display === 'none') {
        getFlights();
        flightsContainer.style.display = 'block';
        toggleButton.textContent = 'Hide Flights';
    } else {
        flightsContainer.style.display = 'none';
        toggleButton.textContent = 'Get Flights';
    }
}

async function getFlight() {
    try {
        const id = document.getElementById('flightId').value;
        const response = await fetch(`${apiUrl}/flight/${id}`);
        const data = await response.json();
        displayFlightDetails(data, 'flightOutput', true);

        // Clear input field
        document.getElementById('flightId').value = '';
    } catch (error) {
        console.error('Error fetching flight:', error);
    }
}

async function addFlight() {
    try {
        const flight = {
            flightOrigin: document.getElementById('flightOrigin').value,
            flightDestination: document.getElementById('flightDestination').value,
            flightDepartureTime: formatDate(
                document.getElementById('flightDepartureDay').value,
                document.getElementById('flightDepartureMonth').value,
                document.getElementById('flightDepartureYear').value,
                document.getElementById('flightDepartureTime').value
            ),
            flightArrivalTime: formatDate(
                document.getElementById('flightArrivalDay').value,
                document.getElementById('flightArrivalMonth').value,
                document.getElementById('flightArrivalYear').value,
                document.getElementById('flightArrivalTime').value
            ),
            capacity: document.getElementById('flightCapacity').value,
            price: document.getElementById('flightPrice').value
        };

        const response = await fetch(`${apiUrl}/flight`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(flight)
        });

        const data = await response.json();
        displayFlightDetails(data, 'addFlightOutput', true);

        // Clear input fields
        document.getElementById('flightOrigin').value = '';
        document.getElementById('flightDestination').value = '';
        document.getElementById('flightDepartureDay').value = '';
        document.getElementById('flightDepartureMonth').value = '';
        document.getElementById('flightDepartureYear').value = '';
        document.getElementById('flightDepartureTime').value = '';
        document.getElementById('flightArrivalDay').value = '';
        document.getElementById('flightArrivalMonth').value = '';
        document.getElementById('flightArrivalYear').value = '';
        document.getElementById('flightArrivalTime').value = '';
        document.getElementById('flightCapacity').value = '';
        document.getElementById('flightPrice').value = '';
    } catch (error) {
        console.error('Error adding flight:', error);
    }
}

async function updateFlight() {
    try {
        const id = document.getElementById('updateFlightId').value;
        const flight = {
            flightOrigin: document.getElementById('updateFlightOrigin').value,
            flightDestination: document.getElementById('updateFlightDestination').value,
            flightDepartureTime: formatDate(
                document.getElementById('updateFlightDepartureDay').value,
                document.getElementById('updateFlightDepartureMonth').value,
                document.getElementById('updateFlightDepartureYear').value,
                document.getElementById('updateFlightDepartureTime').value
            ),
            flightArrivalTime: formatDate(
                document.getElementById('updateFlightArrivalDay').value,
                document.getElementById('updateFlightArrivalMonth').value,
                document.getElementById('updateFlightArrivalYear').value,
                document.getElementById('updateFlightArrivalTime').value
            ),
            capacity: document.getElementById('updateFlightCapacity').value,
            price: document.getElementById('updateFlightPrice').value
        };

        const response = await fetch(`${apiUrl}/flight/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(flight)
        });

        const data = await response.json();
        displayFlightDetails(data, 'updateFlightOutput', true);

        // Clear input fields
        document.getElementById('updateFlightId').value = '';
        document.getElementById('updateFlightOrigin').value = '';
        document.getElementById('updateFlightDestination').value = '';
        document.getElementById('updateFlightDepartureDay').value = '';
        document.getElementById('updateFlightDepartureMonth').value = '';
        document.getElementById('updateFlightDepartureYear').value = '';
        document.getElementById('updateFlightDepartureTime').value = '';
        document.getElementById('updateFlightArrivalDay').value = '';
        document.getElementById('updateFlightArrivalMonth').value = '';
        document.getElementById('updateFlightArrivalYear').value = '';
        document.getElementById('updateFlightArrivalTime').value = '';
        document.getElementById('updateFlightCapacity').value = '';
        document.getElementById('updateFlightPrice').value = '';
    } catch (error) {
        console.error('Error updating flight:', error);
    }
}

async function deleteFlight() {
    try {
        const id = document.getElementById('deleteFlightId').value;
        const response = await fetch(`${apiUrl}/flight/${id}`, {
            method: 'DELETE'
        });

        if (response.status === 204) {
            document.getElementById('deleteFlightOutput').textContent = 'Flight deleted successfully';
        } else {
            document.getElementById('deleteFlightOutput').textContent = 'Failed to delete flight';
        }

        // Clear input field
        document.getElementById('deleteFlightId').value = '';
    } catch (error) {
        console.error('Error deleting flight:', error);
    }
}