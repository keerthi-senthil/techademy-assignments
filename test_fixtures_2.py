import pytest

@pytest.fixture
def regular_user():
    return {
        "username": "keerthi",
        "email": "keerthi10@gmail.com",
        "role": "user",
        "active": True,
        "points": 100
    }

@pytest.fixture
def admin_user():
    return {
        "username": "admin_user",
        "email": "admin@gmail.com",
        "role": "admin",
        "active": True,
        "access_admin_dashboard":True
    }

@pytest.fixture
def inactive_user():
    return {
        "username": "inactive_user",
        "email": "inactive@gmail.com",
        "role": "user",
        "active": False,
        "points": 50
    }

def test_regular_user(regular_user):
    assert regular_user["role"] == "user"
    assert regular_user["active"] is True
    assert len(regular_user["username"]) > 0

def test_admin_user(admin_user):
    assert admin_user["role"] == "admin"
    assert admin_user["active"] is True
    assert admin_user["access_admin_dashboard"] is True

def test_inactive_user(inactive_user):
    assert inactive_user["active"] is False

def test_user_permissions(regular_user, admin_user):
    assert regular_user["role"] != admin_user["role"]
    assert regular_user["active"] is True
    assert admin_user["active"] is True

def test_inactive_user_login(inactive_user,regular_user):
    assert inactive_user["active"] is False
    assert inactive_user["role"] == regular_user["role"]
    assert inactive_user["points"] >= 0

def test_user_email_format(regular_user, admin_user, inactive_user):
    email_format = "@gmail.com"
    assert email_format in regular_user["email"]
    assert email_format in admin_user["email"]
    assert email_format in inactive_user["email"]

def test_user_points_increase(regular_user):
    initial_points = regular_user["points"]
    increase_amount = 25
    regular_user["points"] += increase_amount
    assert regular_user["points"] == initial_points + increase_amount

def test_user_profile_update(regular_user):
    updated_username = "keerthana"
    assert updated_username != regular_user["username"]
    regular_user["username"] = updated_username
    assert regular_user["username"] == updated_username