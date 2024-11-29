<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking System</title>

<style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f8f9fa;
    }
    .header {
      background-color: #007BFF;
      color: white;
      padding: 15px 0;
      text-align: center;
    }
    .container {
      margin: 20px auto;
      max-width: 800px;
      padding: 20px;
      background: white;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }
    .form-group {
      margin: 15px 0;
    }
    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }
    input, select, button {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    button {
      background-color: #007BFF;
      color: white;
      border: none;
      cursor: pointer;
    }
    button:hover {
      background-color: #0056b3;
    }
  </style>

</head>
<body>
<div class="header">
    <h1>Booking System</h1>
  </div>
  <div class="container">
    <form action="processBooking" method="POST">
      <div class="form-group">
        <label for="name">Full Name:</label>
        <input type="text" id="name" name="name" required>
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div class="form-group">
        <label for="date">Booking Date:</label>
        <input type="date" id="date" name="date" required>
      </div>
      <div class="form-group">
        <label for="time">Time Slot:</label>
        <select id="time" name="time" required>
          <option value="10:00 AM">10:00 AM</option>
          <option value="12:00 PM">12:00 PM</option>
          <option value="02:00 PM">02:00 PM</option>
          <option value="04:00 PM">04:00 PM</option>
        </select>
      </div>
      <button type="submit">Book Now</button>
    </form>
  </div>
</body>
</html>