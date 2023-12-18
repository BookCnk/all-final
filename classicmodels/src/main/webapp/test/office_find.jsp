<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table align-items-center mb-0">
    <thead>
    <tr>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
            OfficeCode
        </th>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
            City
        </th>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
            Phone
        </th>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
            AddressLine1
        </th>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
            AddressLine2
        </th>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
            State
        </th>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
            Country
        </th>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
            PostalCode
        </th>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
            Territory
        </th>
        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2 text-center">
            Action
        </th>
    </tr>
    </thead>
        <tbody>
        <c:forEach items="${offices}" var="office">
            <tr>
                <td>
                    <div class="d-flex px-2 py-1">
                        <div class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm">${office.officeCode}</h6>
                            <p class="text-xs text-secondary mb-0">${office.city}</p>
                        </div>
                    </div>
                </td>
                <td>
                    <p class="text-xs font-weight-bold mb-0">${office.city}</p>
                </td>
                <td class="align-middle text-lg-start text-sm">
                    <span class="badge badge-sm bg-gradient-success">${office.phone}</span>
                </td>
                <td class="align-middle text-lg-start">
                    <span class="text-secondary text-xs font-weight-bold">${office.addressLine1}</span>
                </td>
                <td class="align-middle text-lg-start">
                    <span class="text-secondary text-xs font-weight-bold">${office.addressLine2}</span>
                </td>
                <td class="align-middle text-lg-start">
                    <span class="text-secondary text-xs font-weight-bold">${office.state}</span>
                </td>
                <td class="align-middle text-lg-start">
                    <span class="text-secondary text-xs font-weight-bold">${office.country}</span>
                </td>
                <td class="align-middle text-lg-start">
                    <span class="text-secondary text-xs font-weight-bold">${office.postalCode}</span>
                </td>
                <td class="align-middle text-lg-start">
                    <span class="text-secondary text-xs font-weight-bold">${office.territory}</span>
                </td>
                <td class="align-middle text-lg-start">
                    <a data-bs-toggle="modal" data-bs-target="#Delete${office.officeCode}"
                       class="text-secondary font-weight-bold text-xs text-danger"
                       data-toggle="tooltip"
                       data-original-title="Edit user">
                        <i class="far fa-trash-alt me-2"></i>Delete
                    </a>
                    <div class="modal fade" id="Delete${office.officeCode}" tabindex="-1"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Are you
                                        sure?</h5>
                                    <button type="button" class="btn-close"
                                            data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <p>Do you really want to delete these records?</p>
                                    <p>This process cannot be undone.</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal">Cancel
                                    </button>
                                    <a href="office-delete?officeCode=${office.officeCode}">
                                        <button type="button" class="btn btn-primary">
                                            Delete
                                        </button>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    &nbsp;
                    <a href="office-update?officeCode=${office.officeCode}"
                       class="text-secondary font-weight-bold text-xs" data-toggle="tooltip"
                       data-original-title="Edit user">
                        <i class="fas fa-pencil-alt text-dark me-2" aria-hidden="true"></i>Edit
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
</table>