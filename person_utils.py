from typing import Optional
from bson import ObjectId


class Person:
    """Person class matching the MongoDB persons collection schema."""
    
    def __init__(
        self,
        firstName: str,
        lastName: str,
        age: Optional[int] = None,
        city: Optional[str] = None,
        gender: Optional[str] = None,
        _id: Optional[ObjectId] = None
    ):
        self._id = _id
        self.firstName = firstName
        self.lastName = lastName
        self.age = age
        self.city = city
        self.gender = gender
    
    def to_dict(self) -> dict:
        """Convert Person object to dictionary for MongoDB insertion."""
        data = {
            "firstName": self.firstName,
            "lastName": self.lastName
        }
        if self.age is not None:
            data["age"] = self.age
        if self.city is not None:
            data["city"] = self.city
        if self.gender is not None:
            data["gender"] = self.gender
        if self._id is not None:
            data["_id"] = self._id
        return data
    
    @classmethod
    def from_dict(cls, data: dict) -> 'Person':
        """Create Person object from MongoDB document."""
        return cls(
            firstName=data.get("firstName"),
            lastName=data.get("lastName"),
            age=data.get("age"),
            city=data.get("city"),
            gender=data.get("gender"),
            _id=data.get("_id")
        )
    
    def __repr__(self) -> str:
        return f"Person(firstName='{self.firstName}', lastName='{self.lastName}', age={self.age}, city='{self.city}', gender='{self.gender}')"
    
    def get_full_name(self) -> str:
        """Return the full name of the person."""
        return f"{self.firstName} {self.lastName}"
